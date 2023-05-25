<template>
  <div>
    <h1>이용한 운동 시설 목록</h1>
    <div style="float: right">
      <router-link style="font-size: 0.7em" :to="{ name: 'fac-search' }"
        >검색결과 목록으로</router-link
      >
    </div>

    <div v-if="usefacilities.length">
      <b-table-simple hover>
        <!-- <colgroup>
          <col />
          <col />
          <col />
          <col />
          <col />
          <col />
          <col />
        </colgroup> -->
        <b-thead class="text-center">
          <b-tr>
            <b-th>번호</b-th>
            <b-th>지역구분</b-th>
            <b-th>시설유형</b-th>
            <b-th>시설명</b-th>
            <b-th>주소</b-th>
          </b-tr>
        </b-thead>
        <b-tbody class="text-center">
          <FacilityUseListRow
            v-for="(facility, index) in usefacilities"
            :key="index"
            :no="`${index + 1}`"
            :address1="facility.address1"
            :factype="facility.factype"
            :facname="facility.facname"
            :fulladdress2="facility.fulladdress2"
          >
          </FacilityUseListRow>
        </b-tbody>
      </b-table-simple>
    </div>
  </div>
</template>

<script>
import FacilityUseListRow from "@/components/subs/include/FacilityUseListRow.vue";
import { mapGetters } from "vuex";

export default {
  name: "FacilityUseList",
  data() {
    return {
      user_id: this.$store.state.loginUser.id,
    };
  },
  components: {
    FacilityUseListRow,
  },
  computed: {
    ...mapGetters(["usefacilities"]),
  },

  created() {
    this.$store.dispatch("getUseFacilities", this.user_id);
  },
};
</script>

<style scoped>
th {
  font-size: 0.6em;
  vertical-align: middle;
}
</style>
