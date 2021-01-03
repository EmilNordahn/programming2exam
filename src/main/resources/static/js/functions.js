function checkJQuery(){
    if (typeof jQuery != undefined){
        console.log("Jquery is loaded")
    } else {
        console.log("Jquery is NOT loaded")
    }
}

function preventCreateFormFromSending(formInput){
    formInput.submit(function (event){
        console.log("Pressed submit with values "+ $("#firstName").val() + ", " + $("#lastName").val() + ", " + $("#email").val() + ", " + $("#types").val() + ", "+ $("#sId").val());
        event.preventDefault();
        addPerson($("#firstName").val(), $("#lastName").val(), $("#email").val(), $("#types").val(), $("#sId").val())
    });
}

// function preventStudentFormFromSending(createForm){
//     createForm.submit(function (event){
//         console.log("Pressed add person with values: "+ $("#firstName").val() + ", " + $("#lastName").val() + ", " + $("#email").val() + ", " + $("#types").val())
//         event.preventDefault();
//
//
//         //rest of params:
//         addPerson($("#firstName").val(), $("#lastName").val(), $("#email").val(), $("#types").val(), $("#sId").val())
//     });
// }
//rest of params:
function addPerson(firstName , lastName, email, type, sId){
    //rest of params:
    console.log("Addperson called with params: " + firstName + ", " + lastName + ", " + email + ", " + type + ", " + sId)

    var createObject = {};
    //remember all the values
    createObject["firstName"] = firstName;
    createObject["lastName"] = lastName;
    createObject["email"] = email;
    createObject["type"] = type;
    createObject["sId"] = sId;
    console.log(createObject);

    $.ajax(
        {
            url: "/api/addStudent",
            type: "POST",
            contentType: "application/JSON",
            data: JSON.stringify(createObject),
            success:function (data){
                // $("studentTable").append("<tr><td>")
                console.log("SUCCESS FROM SERVER")
                $("#createStatus").html("Server: " + data.request);
                $("#studentTable").append("<tr><td>" + data.firstName + " " + data.lastName + "</td><td>" + data.email + "</td><td>" + data.sId + "</td></tr>")
            },
            error:function(data){
                console.log("ERROR FROM SERVER")
                $("#createStatus").html("ERROR FROM SERVER")
            }
        });
}

function addPerson(firstName , lastName, email, type, sId){
    //rest of params:
    console.log("Addperson called with params: " + firstName + ", " + lastName + ", " + email + ", " + type + ", " + sId)

    var createObject = {};
    //remember all the values
    createObject["firstName"] = firstName;
    createObject["lastName"] = lastName;
    createObject["email"] = email;
    createObject["type"] = type;
    createObject["sId"] = sId;
    console.log(createObject);

    $.ajax(
        {
            url: "/api/addPerson",
            type: "POST",
            contentType: "application/JSON",
            data: JSON.stringify(createObject),
            success:function (data){
                // $("studentTable").append("<tr><td>")
                console.log("SUCCESS FROM SERVER")
                $("#createStatus").html("Server: " + data.request);
                if (type == "student") {
                    if (sId == -1) {
                        $("#studentTable").append("<tr><td>" + data.firstName + " " + data.lastName + "</td><td>" + data.email + "</td><td>No supervisor</td><td><a href='/api/deleteStudent'><button>Delete</button></a><a href='updateStudent'><button>Update</button></a></td></tr>")
                    } else {
                        $("#studentTable").append("<tr><td>" + data.firstName + " " + data.lastName + "</td><td>" + data.email + "</td><td>" + data.sId + "</td><td><a href='/api/deleteStudent'><button>Delete</button></a><a href='updateStudent'><button>Update</button></a></td></tr>")
                    }
                    } else if (type == "supervisor"){
                    $("#supervisorTable").append("<tr><td>" + data.firstName + " " + data.lastName + "</td><td>" + data.email + "</td><td><a href=''><button>Show students</button></a></td><td><a href='/api/deleteStudent'><button>Delete</button></a><a href='updateStudent'><button>Update</button></a></td></tr>");
                }
                },
            error:function(data){
                console.log("ERROR FROM SERVER")
                $("#createStatus").html("ERROR FROM SERVER")
            }
        });
}

function getAllSupervisors(){
    console.log("getAllSupervisors called!");
    $.ajax({
        url: "/api/getSupervisors",
        type: "POST",
        contentType: "application/JSON",
        success:function (data){
            $("#supervisorList").append("<div><table id='supervisorTable'><colgroup><col width='30%'><col width='30%'><col width='20%'><col width='20%'></colgroup><thead><tr><th>Name</th><th>Email</th><th></th><th></th></tr></thead><tbody>");
            $.each(data.supervisors, function (index, value){
                $("#supervisorTable").append("<tr><td>" + value.firstName + " " + value.lastName + "</td><td>" + value.email + "</td><td><a href=''><button>Show students</button></a></td><td><a href='/api/deleteSupervisor'><button>Delete</button></a><a href='updateSupervisor'><button>Update</button></a></td></tr>");
            })
            $("#supervisorList").append("</tbody></table></div>");
        },
        error:function (data){
            console.log("ERROR GETTING SUPERVISORS")
        }
    })
}

function getAllStudents(){
    console.log("getAllStudents called!");
    $.ajax({
        url: "/api/getStudents",
        type: "POST",
        contentType: "application/JSON",
        success:function (data){
            $("#studentList").append("<div><table id='studentTable'><colgroup><col width='30%'><col width='30%'><col width='20%'><col width='20%'></colgroup><thead><tr><th>Name</th><th>Email</th><th>Supervisor</th><th></th></tr></thead><tbody>");
            $.each(data.students, function (index, value){
                if (value.sId == -1 || value.sId == null){
                    console.log(value)
                    console.log(index)
                    $("#studentTable").append("<tr><td>" + value.firstName + " " + value.lastName + "</td><td>" + value.email + "</td><td>No supervisor</td><td><a href='/api/deleteStudent'><button>Delete</button></a><a href='updateStudent'><button>Update</button></a></td></tr>");
                } else {
                    console.log("supervisorId: ");
                    console.log(value.sId)
                    console.log("student values: " + value.firstName + value.lastName + value.email + value.sId);
                    $("#studentTable").append("<tr><td>" + value.firstName + " " + value.lastName + "</td><td>" + value.email + "</td><td>" + value.sId + "</td><td><a href='/api/deleteStudent'><button>Delete</button></a><a href='updateStudent'><button>Update</button></a></td></tr>");
                }
            })
            $("#studentList").append("</tbody></table></div>");
            $("#status").html("Server: got the student");
        },
        error:function (data){
            console.log("ERROR getting the student");
            $("#status").html("ERROR getting the student");
        }
    });
}