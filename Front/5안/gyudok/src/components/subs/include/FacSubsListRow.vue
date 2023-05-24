<template>
  <tr>
    <td>{{ no }}</td>
    <td>FIT PASS</td>
    <td>
      {{ months }}
    </td>
    <td>
      {{ startdate }}
    </td>
    <td>{{ enddate }}</td>
  </tr>
</template>

<script>
export default {
  name: "FacSubListRow",
  props: {
    no: String,
    regdate: String,
    months: Number,
    startdate: String,
    enddate: String,
  },
};
</script>

<style></style>
