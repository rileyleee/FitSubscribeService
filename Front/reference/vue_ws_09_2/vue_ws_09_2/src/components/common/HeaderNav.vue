<template>
  <header>
    <nav>
      <div>
        <router-link :to="{ name: 'HomeView' }">영화 관리</router-link>
      </div>
      <div>
        <router-link :to="{ name: 'movie-create' }">영화 등록</router-link>
        <router-link :to="{ name: 'movie-list' }">영화 목록</router-link>
      </div>
    </nav>
  </header>
</template>

<script>
export default {
  name: "HeaderNav",
};
</script>

<style></style>
