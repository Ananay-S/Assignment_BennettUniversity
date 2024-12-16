class Task {
    constructor(id, title, description, dateTime, label) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dateTime = dateTime;
        this.label = label;
        this.createdDate = new Date();
        this.editedDate = null;
        this.status = "active";
    }
};

let tasks = {
    tasksId:0,
    activeTasks:[],
    archivedTasks:[],
    deletedTasks:[],
    
    // crud create read update delete
    // save (postData)
    postData : function() {
        localStorage.setItem('tasksId', JSON.stringify(this.tasksId));
        localStorage.setItem('activeTaskList', JSON.stringify(this.activeTasks));
        localStorage.setItem('archivedTaskList', JSON.stringify(this.archivedTasks));
        localStorage.setItem('deletedTaskList', JSON.stringify(this.deletedTasks));
    },

    // create
    addTask : function(title,description,dateTime,label) {
        this.tasksId++;
        var newTask = new Task(this.tasksId,title,description,dateTime,label);
        this.activeTasks.push(newTask);
    },

    // update
    taskinfo : function (taskId) {
        var index = this.activeTasks.findIndex(task => task.id == taskId);
        if (index != -1) {
            return this.activeTasks[index];
        }
    },
    updateTask : function (taskId, taskTitle, taskDescription, taskDateTime, taskLabel) {
        var index = this.activeTasks.findIndex(task => task.id == taskId);
        if (index!=-1) {
            this.activeTasks[index].title = taskTitle;
            this.activeTasks[index].description = taskDescription;
            this.activeTasks[index].dateTime = taskDateTime;
            this.activeTasks[index].label = taskLabel;
        }
    },

    // delete
    deleteTaskFromActive : function(taskId) {
        this.moveTask(this.activeTasks,this.deletedTasks,taskId,"deleted");
    },
    deleteTaskFromArchived : function(taskId) {
        this.moveTask(this.archivedTasks,this.deletedTasks,taskId,"deleted");
    },
    deleteTaskFromDeleted : function(taskId) {
        // this.moveTask(this.deletedTasks,this.activeTasks,taskId);
        this.deletedTasks = this.deletedTasks.filter(task=> task.id != taskId);
    },
    
    // archive
    archiveTaskFromActive : function(taskId) {
        this.moveTask(this.activeTasks,this.archivedTasks,taskId,"archived");
    },
    archiveTaskFromDeleted : function(taskId) {
        this.moveTask(this.deletedTasks,this.archivedTasks,taskId,"archived");
    },
    
    // activate
    activateTaskFromArchived : function(taskId) {
        this.moveTask(this.archivedTasks,this.activeTasks,taskId,"active");
    },
    activateTaskFromDeleted : function(taskId) {
        this.moveTask(this.deletedTasks,this.activeTasks,taskId,"active");
    },

    // helper
    moveTask : function(sourceArray,targetArray,taskId,to) {
        var index = sourceArray.findIndex(task => task.id == taskId);
        if (index !== -1) {
            const [removedTask] = sourceArray.splice(index, 1);
            removedTask.status = to;
            targetArray.push(removedTask);
        }
    },

    // search
    searchTaskFromActive : function (query) {
        var result = this.activeTasks.filter(task => {
                if ((task.title.toLowerCase().includes(query))||(task.description.toLowerCase().includes(query))||(task.dateTime.toLowerCase().includes(query))||(task.label.toLowerCase().includes(query))) {
                    return true; // Keep other tasks
                } // Exclude it from the tasks array
            });
        return result;
    },
    searchTaskFromArchived : function (query) {
        var result = this.archivedTasks.filter(task => {
                if ((task.title.toLowerCase().includes(query))||(task.description.toLowerCase().includes(query))||(task.dateTime.toLowerCase().includes(query))||(task.label.toLowerCase().includes(query))) {
                    return true; // Keep other tasks
                } // Exclude it from the tasks array
            });
        return result;
    },
    searchTaskFromDeleted : function (query) {
        var result = this.deletedTasks.filter(task => {
                if ((task.title.toLowerCase().includes(query))||(task.description.toLowerCase().includes(query))||(task.dateTime.toLowerCase().includes(query))||(task.label.toLowerCase().includes(query))) {
                    return true; // Keep other tasks
                } // Exclude it from the tasks array
            });
        return result;
    },

    // sort
    sortTaskFromActive :function (order) {
        // return tasks.sort((a, b) => {
        //     const dateA = new Date(a.dateTime);
        //     const dateB = new Date(b.dateTime);
        //     return order === "asc" ? dateA - dateB : dateB - dateA;
        //   });
        // taskObject.taskArray.sort((a,b) => new Date(a[sortCriteria]) - new Date(b[sortCriteria]));
        return this.activeTasks.sort((a,b)=>order=="asc" ? new Date(a.dateTime) - new Date(b.dateTime) : new Date(b.dateTime) - new Date(a.dateTime));
    },
    sortTaskFromArchived :function (order) {
        return this.archivedTasks.sort((a,b)=>order=="asc" ? new Date(a.dateTime) - new Date(b.dateTime) : new Date(b.dateTime) - new Date(a.dateTime));
    },
    sortTaskFromDeleted :function (order) {
        return this.deletedTasks.sort((a,b)=>order=="asc" ? new Date(a.dateTime) - new Date(b.dateTime) : new Date(b.dateTime) - new Date(a.dateTime));
    },

    // filter
    filterTaskFromActive : function (taskLabel) {
        return this.activeTasks.filter(task=>task.label==taskLabel);
    },
    filterTaskFromArchived : function (taskLabel) {
        return this.archivedTasks.filter(task=>task.label==taskLabel);
    },
    filterTaskFromDeleted : function (taskLabel) {
        return this.deletedTasks.filter(task=>task.label==taskLabel);
    },
};

// read (getData)
(function() {
    var tasksIdData = localStorage.getItem('tasksId');
    tasks.tasksId =  tasksIdData ? JSON.parse(tasksIdData) : 0; 
    // 
    var activeTaskData = localStorage.getItem('activeTaskList');
    tasks.activeTasks =  activeTaskData ? JSON.parse(activeTaskData) : []; 
    // 
    var archivedTaskData = localStorage.getItem('archivedTaskList');
    tasks.archivedTasks =  archivedTaskData ? JSON.parse(archivedTaskData) : []; 
    // 
    var deletedTaskData = localStorage.getItem('deletedTaskList');
    tasks.deletedTasks =  deletedTaskData ? JSON.parse(deletedTaskData) : [];     
})();
