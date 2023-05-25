<template>
  <div>
    <h3>검색한 운동 시설 목록</h3>

    <div v-if="facilities.length">
      <table>
        <thead>
          <tr>
            <th>번호</th>
            <th>지역구분</th>
            <th>시설유형</th>
            <th>시설명</th>
            <th>주소</th>
          </tr>
        </thead>
        <tbody>
          <FacilityListRow
            v-for="(facility, index) in pageFacilityList"
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
    <b-pagination
      size="sm"
      style="padding: 10px"
      v-model="currentPage"
      :total-rows="facilityCount"
      :per-page="perPage"
      align="center"
      first-number
      last-number
    ></b-pagination>
  </div>
</template>

<script>
import FacilityListRow from "@/components/subs/include/FacilityListRow.vue";
import { mapGetters } from "vuex";

export default {
  name: "FacilitySearchResult",
  data() {
    return {
      currentPage: 1,
      perPage: 10,
      mode: 1,
    };
  },
  components: {
    FacilityListRow,
  },
  computed: {
    ...mapGetters(["facilities"]),
    // filteredFacilities() {
    //   // 필터링된 배열을 반환하는 계산된 속성
    //   return this.facilities.slice(0, 15); // 원하는 반복 횟수로 배열을 자르기
    // },
    pageFacilityList() {
      return this.facilities.slice(
        (this.currentPage - 1) * this.perPage,
        this.currentPage * this.perPage
      );
    },
    facilityCount() {
      return this.facilities.length;
    },
  },
  // 여기서 컴포넌트를 생성하자마자 검색하려 하니 keyword 없는 검색이 되어 undefined 출력 오류
  // created() {
  //   this.$store.dispatch("getFacilities");
  // },
};
</script>

<style scoped>
.fulladdtd {
  text-align: left;
}
body {
  padding: 1.5em;
  background: #f5f5f5;
}

table {
  border: 1px #a39485 solid;
  font-size: 0.2em;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.25);
  width: 100%;
  border-collapse: collapse;
  border-radius: 5px;
  overflow: hidden;
}

th {
  text-align: center;
}

thead {
  font-weight: bold;
  color: #fff;
  background: #2b57a1;
}

td,
th {
  padding: 1em 0.5em;
  vertical-align: middle;
}

td {
  border-bottom: 1px solid rgba(0, 0, 0, 0.1);
  background: #fff;
  text-align: center;
}

a {
  color: #73685d;
}

@media all and (max-width: 768px) {
  table,
  thead,
  tbody,
  th,
  td,
  tr {
    display: block;
  }

  th {
    text-align: right;
  }

  table {
    position: relative;
    padding-bottom: 0;
    border: none;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
  }

  thead {
    float: left;
    white-space: nowrap;
  }

  tbody {
    overflow-x: auto;
    overflow-y: hidden;
    position: relative;
    white-space: nowrap;
  }

  tr {
    display: inline-block;
    vertical-align: top;
  }

  th {
    border-bottom: 1px solid #a39485;
  }

  td {
    border-bottom: 1px solid #e5e5e5;
  }
}
</style>
