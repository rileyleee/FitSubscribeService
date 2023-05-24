<template>
  <v-app>
    <h2>운동 시설 구독 껍데기</h2>
    <!-- <facility-search></facility-search> -->
    <!--이렇게 작성하면 이 컴포넌트 딱 하나만 불러서 쓰는 거고 연결 안됩니다.-->
    <router-view />
  </v-app>
</template>

<script>
// import FacilitySearch from "../components/subs/FacilitySearch.vue";
export default {
  name: "FacSubView",
  // components: { FacilitySearch },
};
</script>

<style></style>
