<template>
  <v-container>
    <h1>이용한 운동 시설 목록</h1>

    <div v-if="usefacilities.length">
      <table>
        <colgroup>
          <col />
          <col />
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
            <th>주소</th>
            <th>인덱스</th>
          </tr>
        </thead>
        <tbody>
          <FacilityListRow
            v-for="(facility, index) in usefacilities"
            :key="index"
            :no="`${index + 1}`"
            :address1="facility.address1"
            :factype="facility.factype"
            :facname="facility.facname"
            :rating="facility.rating"
            :fulladdress2="facility.fulladdress2"
            :id="facility.id"
          >
          </FacilityListRow>
        </tbody>
      </table>
    </div>
  </v-container>
</template>

<script>
import FacilityListRow from "@/components/subs/include/FacilityListRow.vue";
import { mapGetters } from "vuex";

export default {
  name: "FacilityUseList",
  data() {
    return {
      user_id: this.$store.state.loginUser.id,
    };
  },
  components: {
    FacilityListRow,
  },
  computed: {
    ...mapGetters(["usefacilities"]),
  },

  created() {
    this.$store.dispatch("getUseFacilities", this.user_id);
  },
};
</script>

<style></style>
