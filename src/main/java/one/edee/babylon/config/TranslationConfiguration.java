package one.edee.babylon.config;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


/**
 * Class representing translation configuration in json file.
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class TranslationConfiguration implements Serializable {

    private static final long serialVersionUID = -5822894615320804365L;

    /**
     * List of all property paths. Can contain path e.g. with character * to match many files by mask like e.g.
     * "META-INF/lib_eshop_edee/productVariant/gui-admin/modifications/*Admin.properties"
     */
    private List<String> path = new ArrayList<>();

    /**
     * Name of the DataFile in Json format which serves as working database for translation process.
     */
    @NonNull
    private String dataFileName;

    @JsonIgnore
    public Path getSnapshotPath() {
        return Paths.get(dataFileName);
    }

    /**
     * List of all mutations to translate (e.g. CZ,EN,...).
     */
    private List<String> mutations = new ArrayList<>();

    public void addFileToPath(String fileName) {
        path.add(fileName);
    }

}
