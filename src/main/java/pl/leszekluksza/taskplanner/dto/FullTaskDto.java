package pl.leszekluksza.taskplanner.dto;

import pl.leszekluksza.taskplanner.model.Category;

import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

public class FullTaskDto {

    @Size(min = 3)
    private String name;
    private Set<Category> categories;
    private String category;
    private String comment;

    public FullTaskDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
