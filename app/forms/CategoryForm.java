package forms;

public class CategoryForm {
    String name;
    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CategoryForm(String name, String id) {

        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryForm() {

    }

    public CategoryForm(String name) {

        this.name = name;
    }
}
