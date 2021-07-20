package otus.apiHelpers.apiHelpersHomework.pojo.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Resource {

    @JsonProperty("data")
    private Data data;

    @JsonProperty("support")
    private Support support;

    public Data getData() {
        return data;
    }

    public Support getSupport() {
        return support;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "data=" + data +
                ", support=" + support +
                '}';
    }
}
