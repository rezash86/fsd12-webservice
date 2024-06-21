const HOST = "http://localhost:8080";

function getUser() {
  $.ajax({
    method: "get",
    url: `${HOST}/user/`,
  })
    .done((response) => {
      document.getElementById("user-name").value = response.name;
      document.getElementById("user-password").value = response.password;
      document.getElementById("user-email").value = response.email;
      document.getElementById("user-age").value = response.age;
    })
    .fail((xhrObj) => alert(xhrObj));
}

function createUser() {
  const name = document.getElementById("user-name").value;
  const password = document.getElementById("user-password").value;
  const email = document.getElementById("user-email").value;
  const age = document.getElementById("user-age").value;

  $.ajax({
    method: "post",
    url: `${HOST}/user/`,
    data: JSON.stringify({
      'name': name,
      'age': age,
      'email': email,
      'password': password,
    }),
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
  }).done((response) => {
    alert("user created " + response);
  });
}
