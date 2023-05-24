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
            v-for="(facility, index) in filteredFacilities"
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
  name: "FacilitySearchResult",

  components: {
    FacilityListRow,
  },
  computed: {
    ...mapGetters(["facilities"]),
    filteredFacilities() {
      // 필터링된 배열을 반환하는 계산된 속성
      return this.facilities.slice(0, 20); // 원하는 반복 횟수로 배열을 자르기
    },
  },
  // 여기서 컴포넌트를 생성하자마자 검색하려 하니 keyword 없는 검색이 되어 undefined 출력 오류
  // created() {
  //   this.$store.dispatch("getFacilities");
  // },
};
</script>

<style></style>
