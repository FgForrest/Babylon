package com.fg.util.babylon

import com.fg.util.babylon.processor.AntPathResourceLoader

class BundleCollector(private val resourceLoader: AntPathResourceLoader) {

    /**
     * @param translationFilePaths paths of message files, path support Ant-style patterns
     * @param translationLangs list of languages whose collect translations bundle should be examined,
     *  might contain new languages that have no translation bundle yet
     */
    fun collectBundles(translationFilePaths: List<String>, translationLangs: List<String>): Pair<MessageBundle, Map<String, MessageBundle>> {
        val allPaths = expand(translationFilePaths)

        val primaryMsgBundle = collectPrimaryBundle(allPaths)
        val translationMsgBundles = translationLangs.map { lang ->
            lang to collectBundle(allPaths, lang)
        }.associateBy({ it.first }, { it.second })
        return primaryMsgBundle to translationMsgBundles
    }

    private fun collectPrimaryBundle(paths: List<String>): MessageBundle {
        //TODO viz processPrimaryMessages
        return emptyMap()
    }

    private fun collectBundle(paths: List<String>, language: Language): MessageBundle {
        //TODO viz loadTranslationProperties
        return emptyMap()
    }

    private fun expand(paths: List<String>): List<String> =
            paths.mapNotNull { resourceLoader.getResources(it) }
                    .map { it.toList() }
                    .flatten()
                    .map { it.file.path }

}