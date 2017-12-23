package forms;

import java.util.ArrayList;
import java.util.List;

public class MenusUpdateForm {
    List<MenuForm> addQueue = new ArrayList<>();
    List<MenuForm> editQueue = new ArrayList<>();
    List<MenuForm> deleteQueue = new ArrayList<>();

    public List<MenuForm> getAddQueue() {
        return addQueue;
    }

    public void setAddQueue(List<MenuForm> addQueue) {
        this.addQueue = addQueue;
    }

    public List<MenuForm> getEditQueue() {
        return editQueue;
    }

    public void setEditQueue(List<MenuForm> editQueue) {
        this.editQueue = editQueue;
    }

    public List<MenuForm> getDeleteQueue() {
        return deleteQueue;
    }

    public void setDeleteQueue(List<MenuForm> deleteQueue) {
        this.deleteQueue = deleteQueue;
    }

    public MenusUpdateForm() {

    }

    public MenusUpdateForm(List<MenuForm> addQueue, List<MenuForm> editQueue, List<MenuForm> deleteQueue) {

        this.addQueue = addQueue;
        this.editQueue = editQueue;
        this.deleteQueue = deleteQueue;
    }

}
