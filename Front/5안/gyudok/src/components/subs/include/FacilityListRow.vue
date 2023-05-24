<template>
  <tr>
    <td>{{ no }}</td>
    <td>{{ address1 }}</td>
    <td>
      {{ factype }}
    </td>
    <td>
      <router-link :to="{ name: 'fac-detail', query: { id: id } }">{{
        facname
      }}</router-link>
    </td>
    <td>{{ rating }}</td>
    <td>{{ fulladdress2 }}</td>
    <td>{{ id }}</td>
  </tr>
</template>

<script>
export default {
  name: "FacilityListRow",
  props: {
    no: String,
    address1: String,
    factype: String,
    facname: String,
    rating: Number,
    fulladdress2: String,
    id: Number,
  },
};
</script>

<style></style>
