function renderTasks(tasks) {
    taskContainer.innerHTML = tasks.map(task => {
        if (task.status=="active") {
            
            return `
                <div class="col">
                    <div class="card h-100">
                        <div class="card-body">
                            <h5 class="card-title d-flex justify-content-between">
                                ${task.title}
                                <button class="btn" data-bs-toggle="tooltip" data-bs-placement="top" title="Created: 13/12/2024 | Edited: 14/12/2024"> <!--text-white--> <!--nothing-->
                                <i class="bi bi-info-circle-fill"></i>
                                </button>
                            </h5>
        
                            <h6 class="card-subtitle mb-4">${new Date(task.dateTime).toLocaleString()}</h6>
        
                            <p class="card-text mb-4">${task.description}</p>
                            
                            <div class="d-flex justify-content-between align-items-center">
                                <span class="badge bg-primary">${task.label}</span>
                                
                                <div>
                                    <button class="btn btn-sm btn-outline-success" onclick="editTaskHandler('${task.id}')">
                                    <i class="bi bi-pencil-square" ></i>
                                    </button>
        
                                    <button class="btn btn-sm btn-outline-warning" onclick="archiveTaskHandler('${task.id}','${task.status}')">
                                    <i class="bi bi-archive-fill"></i>
                                    </button>
                                    
                                    <button class="btn btn-sm btn-outline-danger" onclick="deleteTaskHandler('${task.id}','${task.status}')">
                                    <i class="bi bi-trash-fill"></i>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            `
        } else {
            return `
                <div class="col">
                    <div class="card h-100">
                        <div class="card-body">
                            <h5 class="card-title d-flex justify-content-between">
                                ${task.title}
                                <button class="btn" data-bs-toggle="tooltip" data-bs-placement="top" title="Created: 13/12/2024 | Edited: 14/12/2024"> <!--text-white--> <!--nothing-->
                                <i class="bi bi-info-circle-fill"></i>
                                </button>
                            </h5>
        
                            <h6 class="card-subtitle mb-4">${new Date(task.dateTime).toLocaleString()}</h6>
        
                            <p class="card-text mb-4">${task.description}</p>
                            
                            <div class="d-flex justify-content-between align-items-center">
                                <span class="badge bg-primary">${task.label}</span>
                                
                                <div>
                                    <button class="btn btn-sm btn-outline-success" onclick="restoreTaskHandler('${task.id}','${task.status}')">
                                    <i class="bi bi-arrow-counterclockwise"></i>
                                    </button>
        
                                    <button class="btn btn-sm btn-outline-warning" onclick="archiveTaskHandler('${task.id}','${task.status}')">
                                    <i class="bi bi-archive-fill"></i>
                                    </button>
                                    
                                    <button class="btn btn-sm btn-outline-danger" onclick="deleteTaskHandler('${task.id}','${task.status}')">
                                    <i class="bi bi-trash-fill"></i>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            `
        }
    }
).join("");
};