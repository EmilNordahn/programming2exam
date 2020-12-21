function checkJQuery(){
    if (typeof jQuery != undefined){
        console.log("Jquery is loaded")
    } else {
        console.log("Jquery is NOT loaded")
    }
}

function preventCreateFormFromSending(createForm){
    createForm.submit(function (event){
        console.log("Pressed add person with values: "+ $("#firstName").val() + ", " + $("#lastName").val() + ", " + $("#email").val() + ", " + $("#types").val())
        event.preventDefault();


        //rest of params:
        addPerson($("#firstName").val(), $("#lastName").val(), $("#email").val(), $("#types").val())
    });
}
//rest of params:
function addPerson(firstName , lastName, email, type){
    //rest of params:
    console.log("Addperson called with params: " + firstName + ", " + lastName + ", " + email + ", " + type)

    var createObject = {};
    //remember all the values
    createObject["firstName"] = firstName;
    createObject["lastName"] = lastName;
    createObject["email"] = email;
    createObject["type"] = type;
    console.log(createObject);


    var table = document.getElementById("studentTable")



    $.ajax(
        {
            url: "/api/add",
            type: "POST",
            contentType: "application/JSON",
            data: JSON.stringify(createObject),
            success:function (data){
                console.log("SUCCESS FROM SERVER")
                $("#createStatus").html("Server: " + data.message);
            },
            error:function(data){
                console.log("ERROR FROM SERVER")
                $("#createStatus").html("ERROR FROM SERVER")
            }
        });
}

function updateTable(){
    var xhttp;
    xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange =function (){

    }
}

