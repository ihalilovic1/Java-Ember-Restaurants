package forms;

import java.util.ArrayList;
import java.util.List;

public class TablesUpdateForm {
    List<TableForm> addQueue = new ArrayList<>();
    List<TableForm> editQueue = new ArrayList<>();
    List<TableForm> deleteQueue = new ArrayList<>();

    public List<TableForm> getAddQueue() {
        return addQueue;
    }

    public void setAddQueue(List<TableForm> addQueue) {
        this.addQueue = addQueue;
    }

    public List<TableForm> getEditQueue() {
        return editQueue;
    }

    public void setEditQueue(List<TableForm> editQueue) {
        this.editQueue = editQueue;
    }

    public List<TableForm> getDeleteQueue() {
        return deleteQueue;
    }

    public void setDeleteQueue(List<TableForm> deleteQueue) {
        this.deleteQueue = deleteQueue;
    }

    public TablesUpdateForm() {

    }

    public TablesUpdateForm(List<TableForm> addQueue, List<TableForm> editQueue, List<TableForm> deleteQueue) {

        this.addQueue = addQueue;
        this.editQueue = editQueue;
        this.deleteQueue = deleteQueue;
    }
}
