<template>
  <div>
    <h2>운동시설 구독권 신청하기</h2>
    <span>
      {{ months }}월 동안 운동시설을 구독하겠습니다.
      <select v-model="months" @change="subscribe()">
        <option v-for="month in monthList" :key="month.id" :value="month.value">
          {{ month.value }}개월 구독
        </option>
      </select>
    </span>
    <MyFacSubscribe></MyFacSubscribe>
  </div>
</template>

<script>
import MyFacSubscribe from "./MyFacSubscribe.vue";
export default {
  name: "FacilitySubscribe",
  components: { MyFacSubscribe },
  data() {
    return {
      months: "0",
      monthList: [
        {
          id: 1,
          value: 1,
        },
        {
          id: 2,
          value: 3,
        },
        {
          id: 3,
          value: 6,
        },
        {
          id: 4,
          value: 9,
        },
        {
          id: 5,
          value: 12,
        },
      ],
    };
  },
  methods: {
    subscribe() {
      let fit_sub = {
        user_id: this.$store.state.loginUser.id,
        months: this.months,
      };
      this.$store.dispatch("setSubscription", fit_sub);
    },
  },
};
</script>

<style></style>
