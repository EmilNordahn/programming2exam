//Del af mit forsøg på at løse opgave 2, kunne ikke få programmet til at vise nye oprettede students
//uden at refreshe hele siden
//
// function checkJQuery(){
//     if (typeof jQuery != undefined){
//         console.log("Jquery is loaded")
//     } else {
//         console.log("Jquery is NOT loaded")
//     }
// }
//
// function preventCreateFormFromSending(createForm){
//     createForm.submit(function (event){
//         console.log("Pressed add person with values: "+ $("#firstName").val() + ", " + $("#lastName").val() + ", " + $("#email").val() + ", " + $("#types").val())
//         event.preventDefault();
//
//
//         //rest of params:
//         addPerson($("#firstName").val(), $("#lastName").val(), $("#email").val(), $("#types").val())
//     });
// }
// //rest of params:
// function addPerson(firstName , lastName, email, type){
//     //rest of params:
//     console.log("Addperson called with params: " + firstName + ", " + lastName + ", " + email + ", " + type)
//
//     var createObject = {};
//     //remember all the values
//     createObject["firstName"] = firstName;
//     createObject["lastName"] = lastName;
//     createObject["email"] = email;
//     createObject["type"] = type;
//     console.log(createObject);
//
//
//     // var table = document.getElementById("studentTable")
//
//
//
//     $.ajax(
//         {
//             url: "/api/add",
//             type: "POST",
//             contentType: "application/JSON",
//             data: JSON.stringify(createObject),
//             success:function (data){
//                 // $("#testStudent").prepend("<div>" + data.testStudent.pop().firstName + "</div>")
//                 console.log("SUCCESS FROM SERVER")
//                 $("#createStatus").html("Server: " + data.message);
//             },
//             error:function(data){
//                 console.log("ERROR FROM SERVER")
//                 $("#createStatus").html("ERROR FROM SERVER")
//             }
//         });
// }
//
// function getAllStudents(){
//     console.log("getAllStudents called!");
//
//     $.ajax({
//         url: "api/getStudents",
//         type:"POST",
//         contentType: "application/JSON",
//         success:function (data){
//             $.each(data.students, function (index, value){
//                 $("studentTable").append("<div>" + value.firstName)
//             })
//             $("#status").html("Server: got the student");
//         },
//         error:function (data){
//             console.log("ERROR getting the student");
//             $("#status").html("ERROR getting the student");
//         }
//     });
// }