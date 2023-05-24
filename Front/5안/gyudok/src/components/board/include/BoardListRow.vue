<template>
  <tr>
    <td>{{ no }}</td>
    <td>{{ category }}</td>
    <td>
      <router-link :to="{ name: 'boardDetail', query: { id: no } }">{{
        title
      }}</router-link>
    </td>
    <td>{{ content }}</td>
    <td>{{ viewcnt }}</td>
    <td>{{ regdate }}</td>
  </tr>
</template>

<script>
export default {
  name: "ListRow",
  props: {
    no: Number,
    category: String,
    title: String,
    content: String,
    viewcnt: Number,
    regdate: String,
  },
};
</script>

<style></style>
