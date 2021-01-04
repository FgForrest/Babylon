package com.fg.util.babylon.export

import com.fg.util.babylon.sheets.gsheets.model.ASheet

/**
 * Fake implementation of [NewExporter.SheetContract] for testing only.
 */
class FakeExporterSheetContractImpl : NewExporter.SheetContract {

    val sheets: MutableMap<String, List<ASheet>> = mutableMapOf()
    private var nextId = 1;

    override fun listSheets(spreadsheetId: String?): List<ASheet> =
            sheets[spreadsheetId] ?: emptyList()

    override fun deleteSheets(spreadsheetId: String?, sheetIds: MutableCollection<Int>?) {
        sheets[spreadsheetId!!] = sheets[spreadsheetId]!!.filter { !sheetIds!!.contains(it.id) }
    }

    override fun createSheet(spreadsheetId: String?, sheetTitle: String?, sheetRows: MutableList<MutableList<String>>?, lockedCellEditors: MutableList<String>?) {
        sheets[spreadsheetId!!] = sheets[spreadsheetId] ?: emptyList<ASheet>() + listOf(FakeSheet(getAndIncId()))
    }

    private fun getAndIncId(): Int {
        val id = nextId
        this.nextId += 1
        return id
    }

}

class FakeSheet(private val sheetId: Int) : ASheet {

    override fun getId(): Int = sheetId

}