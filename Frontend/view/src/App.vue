<template>
  <div id="app" class="container">
    <div id="header">
      <center>
        <h1><router-link to="/" class="h1">Bente in IJsland</router-link></h1>
      </center>
    </div>
    <router-view/>
  </div>
</template>

<style>
a:link {
  color: rgb(0, 247, 255);
}

a:visited {
  color: rgb(0, 247, 255);
}

/* mouse over link */
a:hover {
  color: rgb(255, 0, 212);
}

h2 {
  color: rgb(0, 247, 255);
  text-align: center;
}

body {
  background-color: black;
}

#header {
  background-color: gray;
}

p {
  color: rgb(0, 247, 255);
}

img {
}
</style>
