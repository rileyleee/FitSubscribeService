<template>
  <v-container>
    
    <h1>검색한 운동 시설 목록</h1>

    <div v-if="facilities.length">
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
            <th>지역구분</th>
            <th>시설유형</th>
            <th>시설명</th>
            <th>평점</th>
            <th>시설주소</th>
          </tr>
        </thead>
        <tbody>
          <FacilityListRow
            v-for="(facility, index) in facilities"
            :key="index"
            :no="`${index + 1}`"
            :address1="facility.address1"
            :factype="facility.factype"
            :facname="facility.facname"
            :rating="facility.rating"
            :fulladdress="facility.fulladdress"
          >
          </FacilityListRow>
        </tbody>
      </table>
    </div>
  <v-container>
</template>

<script>
import FacilityListRow from "@/components/subs/include/FacilityListRow.vue";
import { mapGetters } from "vuex";

export default {
  name: "FacilitySearch",
 
  components: {
    FacilityListRow,
  },
  computed: {
    ...mapGetters(["facilities"]),
  },
  created() {
    this.$store.dispatch("getFacilities");
  },
};
</script>

<style></style>
