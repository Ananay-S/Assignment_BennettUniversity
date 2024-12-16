function initEvents() {
    console.log("initEvents");
    
    initEventListners();
    activeSectionHandler();
};

function initEventListners() {
    console.log("initEventListners");
    
    document.querySelector("#navbarActiveSection").addEventListener("click",activeSectionHandler);
    document.querySelector("#navbarSearch").addEventListener("input",searchHandler);

    document.querySelector("#navbarAddTask").addEventListener("click",addTaskHandler);
    document.querySelector("#navbarArchivedSection").addEventListener("click",archivedSectionHandler);
    document.querySelector("#navbarDeletedSection").addEventListener("click",deletedSectionHandler);
    document.querySelector("#navbarReload").addEventListener("click",reloadHandler);

    // 
    document.querySelector('#clearTask1').addEventListener("click",clearTaskHandler);
    document.querySelector('#clearTask2').addEventListener("click",clearTaskHandler);
    document.querySelector('#saveTask').addEventListener("click",saveTaskHandler);
    document.querySelector('#updateTask').addEventListener("click",updateTaskHandler);
};

// NAVBAR HANDLERS
function activeSectionHandler() {
    console.log("active-Section-Handler");
    document.querySelector('#taskContainer').setAttribute("name","active");
    renderTasks(tasks.activeTasks);
};

function searchHandler() {
    console.log("search-Handler");
    let section = document.querySelector('#taskContainer').getAttribute("name");
    let query = document.querySelector('#navbarSearch').value.toLowerCase();
    switch (section) {
        case "active":
            renderTasks(tasks.searchTaskFromActive(query));
            break;
        case "archived":
            renderTasks(tasks.searchTaskFromArchived(query));
            break;
        default:
            renderTasks(tasks.searchTaskFromDeleted(query));
            break;
    }
};

function sortHandler(order) {
    console.log("sort-Handler");
    let section = document.querySelector('#taskContainer').getAttribute("name");
    switch (section) {
        case "active":
            renderTasks(tasks.sortTaskFromActive(order));
            break;
        case "archived":
            renderTasks(tasks.sortTaskFromArchived(order));
            break;
        default:
            renderTasks(tasks.sortTaskFromDeleted(order));
            break;
    }
};

function filterHandler(taskLabel) {
    console.log("filter-Handler: ",taskLabel);
    let section = document.querySelector('#taskContainer').getAttribute("name");
    switch (section) {
        case "active":
            renderTasks(tasks.filterTaskFromActive(taskLabel));
            break;
        case "archived":
            renderTasks(tasks.filterTaskFromArchived(taskLabel));
            break;
        default:
            renderTasks(tasks.filterTaskFromDeleted(taskLabel));
            break;
    }
};

function addTaskHandler() {
    console.log("add-Task-Handler");
    // let section = document.querySelector('#taskContainer').getAttribute("name");
    let section ="active";
    if (section=="active") {
        const modal = document.querySelector('#TaskModal');
        const taskModal = new bootstrap.Modal(modal);
        taskModal.show();
    } else {
        alert("Can only add task in active section");
    }
};

function archivedSectionHandler() {
    console.log("archived-Section-Handler");
    document.querySelector('#taskContainer').setAttribute("name","archived");
    renderTasks(tasks.archivedTasks);
};

function deletedSectionHandler() {
    console.log("deleted-Section-Handler");
    document.querySelector('#taskContainer').setAttribute("name","deleted");
    renderTasks(tasks.deletedTasks);
};

function reloadHandler() {
    console.log("reload-Handler");
    document.querySelector('#navbarSearch').value = "";
    activeSectionHandler();
};

// MODAL HANDLER
function clearTaskHandler() {
    document.getElementById('taskTitle').value="";
    document.getElementById('taskDescription').value="";
    document.getElementById('taskDateTime').value="";
    document.getElementById('taskLabel').value="";
}
function saveTaskHandler() {
    var title = document.getElementById('taskTitle').value;
    var description = document.getElementById('taskDescription').value;
    var dateTime = document.getElementById('taskDateTime').value;
    var label = document.getElementById('taskLabel').value;
    if (title&&dateTime&&label) {
        console.log("saveTaskHandler: ",{title, description, dateTime, label});
        tasks.addTask(title, description, dateTime, label);
        tasks.postData();
        activeSectionHandler();
        const thisModal = bootstrap.Modal.getInstance(document.querySelector('#TaskModal'));
        thisModal.hide(); // Close the modal programmatically
        clearTaskHandler();     
    } else {
        alert("Please fill in all required fields.");
    }
};

function updateModalTaskHandler() {
    console.log("update-Task-Handler");
    // let section = document.querySelector('#taskContainer').getAttribute("name");
    let section ="active";
    if (section=="active") {
        const umodal = document.querySelector('#UpdateTaskModal');
        const taskUModal = new bootstrap.Modal(umodal);
        taskUModal.show();
    } else {
        alert("Can only update task in active section");
    }
};
function updateTaskHandler() {
    var title = document.getElementById('taskTitleUpdate').value;
    var description = document.getElementById('taskDescriptionUpdate').value;
    var dateTime = document.getElementById('taskDateTimeUpdate').value;
    var label = document.getElementById('taskLabelUpdate').value;
    var id = document.getElementById('ID').value;
    if (title&&dateTime&&label) {
        console.log("updateTaskHandler: ",{title, description, dateTime, label});
        // 
        tasks.updateTask(id,title, description, dateTime, label);
        tasks.postData();
        activeSectionHandler();
        const thisModal = bootstrap.Modal.getInstance(document.querySelector('#UpdateTaskModal'));
        thisModal.hide(); // Close the modal programmatically
        // clearTaskHandler();     
    } else {
        alert("Please fill in all required fields.");
    }
};

// CARD HANDLER
function editTaskHandler(taskId) {
    console.log("edit-Task-Handler: ",taskId);
    let task = tasks.taskinfo(taskId);
    // settask reloadHandler;
    document.getElementById('taskTitleUpdate').value = task.title;
    document.getElementById('taskDescriptionUpdate').value = task.description;
    document.getElementById('taskDateTimeUpdate').value = task.dateTime;
    document.getElementById('taskLabelUpdate').value = task.label;
    document.getElementById('ID').value = taskId;
    updateModalTaskHandler();


    // activeSectionHandler();
    // tasks.postData();
};
function restoreTaskHandler(taskId, taskStatus) {
    console.log("restore-Task-Handler: ",taskId,taskStatus);
    switch (taskStatus) {
        case "active":
            break;
        case "archived":
            tasks.activateTaskFromArchived(taskId);
            archivedSectionHandler();
            break;
        default:
            tasks.activateTaskFromDeleted(taskId);
            deletedSectionHandler();
            break;
    }
    tasks.postData();
};
function archiveTaskHandler(taskId, taskStatus) {
    console.log("archive-Task-Handler: ",taskId,taskStatus);
    switch (taskStatus) {
        case "active":
            tasks.archiveTaskFromActive(taskId);
            activeSectionHandler();
            break;
        case "archived":
            break;
        default:
            tasks.archiveTaskFromDeleted(taskId);
            deletedSectionHandler();
            break;
    }
    tasks.postData();
};
function deleteTaskHandler(taskId, taskStatus) {
    console.log("delete-Task-Handler: ",taskId,taskStatus);
    switch (taskStatus) {
        case "active":
            tasks.deleteTaskFromActive(taskId);
            activeSectionHandler();
            break;
        case "archived":
            tasks.deleteTaskFromArchived(taskId);
            archivedSectionHandler();
            break;
        default:
            tasks.deleteTaskFromDeleted(taskId);
            deletedSectionHandler();
            break;
    }
    tasks.postData();
};

// Initaialize 
document.addEventListener('DOMContentLoaded',initEvents());