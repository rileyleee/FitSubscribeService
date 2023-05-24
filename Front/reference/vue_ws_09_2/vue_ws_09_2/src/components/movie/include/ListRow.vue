<template>
  <tr>
    <td>{{ no }}</td>
    <td>
      <router-link :to="{ name: 'movie-detail', query: { id: no } }">{{
        title
      }}</router-link>
    </td>
    <td>{{ director }}</td>
    <td>{{ genre }}</td>
    <td>{{ runningTime }}</td>
    <td>{{ likeCnt }}</td>
  </tr>
</template>

<script>
export default {
  name: "ListRow",
  props: {
    no: String,
    title: String,
    director: String,
    genre: String,
    runningTime: Number,
    likeCnt: Number,
  },
};
</script>

<style></style>
