package utilities;

public class ReportNameValues {
    private String id;
    private String name;
    private String modelId;

    public ReportNameValues(String id, String name, String modelId) {
        this.id = id;
        this.name = name;
        this.modelId = modelId;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getModelId() {
        return modelId;
    }
}
