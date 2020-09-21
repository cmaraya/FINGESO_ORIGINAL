<template>
  <div id="app">
    <nav class="navbar shadownavbar navbar-static-top navbar-expand navbar-light py-3">
	  <img src="assets/logo.png" class="mx-auto img-fluid d-block logo" alt="Logo" />
    </nav>

    <div class="container">
		<transition name="router-anim" enter-active-class="animated fadeInUp" leave-active-class="animated fadeOutDown">
			<router-view />
		</transition>
    </div>
  </div>
</template>

<script>
export default {
  name: 'app'
}
</script>


<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

.shadownavbar {
    -webkit-box-shadow: 0 8px 6px -6px #999;
    -moz-box-shadow: 0 8px 6px -6px #999;
    box-shadow: 0 8px 6px -6px #999;
}

.logo {
	height: 45px;
	width: 170px;
}

@import "https://cdn.jsdelivr.net/npm/animate.css@3.5.1";

	
</style>
