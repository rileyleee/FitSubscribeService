<template>
  <tr>
    <td>{{ no }}</td>
    <td>{{ address1 }}</td>
    <td>{{ factype }}</td>
    <td>
      <router-link :to="{ name: 'fac-detail', query: { id: id } }">
        {{ facname }}
      </router-link>
    </td>
    <td class="fulladdtd">{{ fulladdress2 }}</td>
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

<style scoped>
  
 td {
  font-size: 0.5em;
  vertical-align: middle;
}
  
 
</style>
