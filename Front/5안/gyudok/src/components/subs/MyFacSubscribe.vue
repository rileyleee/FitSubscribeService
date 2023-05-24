<template>
  <v-container>
    <h1>나의 구독 내역</h1>

    <div v-if="subscriptions.length">
      <table>
        <colgroup>
          <col />
          <col />
          <col />
          <col />
          <col />
        </colgroup>
        <thead>
          <tr>
            <th>번호</th>
            <th>구독 신청일</th>
            <th>구독기간</th>
            <th>구독 시작일</th>
            <th>구독 종료일</th>
          </tr>
        </thead>
        <tbody>
          <FacSubsListRow
            v-for="(subscription, index) in subscriptions"
            :key="index"
            :no="`${index + 1}`"
            :regdate="subscription.regdate.toString().split(' ')[0]"
            :months="subscription.months"
            :startdate="subscription.startdate.map(String).join('.')"
            :enddate="subscription.enddate.map(String).join('.')"
          >
          </FacSubsListRow>
        </tbody>
      </table>
    </div>
  </v-container>
</template>

<script>
import FacSubsListRow from "./include/FacSubsListRow.vue";
import { mapGetters } from "vuex";

export default {
  name: "MyFacSubscribe",
  data() {
    return {
      user_id: this.$store.state.loginUser.id,
    };
  },

  components: {
    FacSubsListRow,
  },
  computed: {
    ...mapGetters(["subscriptions"]),
  },

  created() {
    this.$store.dispatch("getSubscriptions", this.user_id);
  },
};
</script>

<style></style>
