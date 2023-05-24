<template>
  <v-app>
    <v-container>
      <h2>운동시설 검색하기(광역시도, 시군구, 운동시설 유형, 운동시설명)</h2>
      <!--운동종류-->
      <!--체력단련장(필라테스, 피트니스),태권도,인공암벽장,골프(장),합기도,
테니스(장),배드민턴,권투,농구,축구,유도,수영장-->
      <fieldset class="text-center">
        <label for="keyword">검색어</label>
        <input
          type="text"
          id="keyword"
          v-model="keyword"
          class="view"
          placeholder="검색어를 입력해주세요"
          @keyup.enter="searchFacs"
        /><br />
        <button class="btn" @click="searchFacs">검색</button>
      </fieldset>
      <FacilitySearchResult :keyword="keyword"></FacilitySearchResult>
      <router-link :to="{ name: 'fac-subscribe' }"
        >운동시설 구독권 신청하기</router-link
      ><br />
      <router-link :to="{ name: 'fac-use' }">이용한 운동시설 목록</router-link>
    </v-container>
  </v-app>
</template>

<script>
import FacilitySearchResult from "./FacilitySearchResult.vue";
export default {
  name: "FacilitySearch",
  components: {
    FacilitySearchResult,
  },
  data() {
    return {
      keyword: null,
    };
  },
  methods: {
    searchFacs() {
      let keyword = this.keyword;
      if (keyword === null) {
        alert(
          "검색어를 입력해주세요(광역시도, 시군구, 운동시설 유형, 운동시설명)"
        );
        return;
      } else {
        this.$store.dispatch("getFacilities", keyword); // 이거 끝나고 구독홈 가는 길이나, 구독하기 버튼 눌렀을 때 faciliites를 초기화 해줘야 해!
      }
    },
  },
};
</script>

<style></style>
