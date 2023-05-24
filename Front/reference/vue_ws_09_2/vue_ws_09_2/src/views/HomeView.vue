<template>
  <div class="container">
    <div class="text-center">
      <img src="@/assets/ssafy_logo.png" alt="" />
      <h1>{{ $store.state.infoMessage }}</h1>
    </div>
    <br />
    <movie-search></movie-search>
  </div>
</template>

<script>
export default {
  name: "MainPage",
  components: {},
};
</script>
<style>
.text-center {
  text-align: center;
}
</style>
