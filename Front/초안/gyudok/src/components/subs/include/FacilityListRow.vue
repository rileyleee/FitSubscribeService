<template>
  <tr>
    <td>{{ no }}</td>
     <td>{{ address1 }}</td>
    <td>
      {{ factype }}
    </td>
    <td>{{ facname }}</td>
    <td>{{ rating }}</td>
    <td>{{ fulladdress1 }}</td>
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
    fulladdress1: String,
  },
};
</script>

<style>
</style>