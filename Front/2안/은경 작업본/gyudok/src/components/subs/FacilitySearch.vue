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
        /><br />
        <button class="btn" @click="searchFacs">검색</button>
      </fieldset>
      <FacilitySearchResult :keyword="keyword"></FacilitySearchResult>
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
      keyword: "",
    };
  },
  methods: {
    searchFacs() {
      let keyword = this.keyword;
      // console.log(
      //   `http://localhost:9999/gyudok-subs/facsubs/search/${keyword}`
      // );
      if (keyword === null) {
        alert(
          "검색어를 입력해주세요(광역시도, 시군구, 운동시설 유형, 운동시설명)"
        );
        return;
      } else {
        // console.log(keyword);
        this.$store.dispatch("getFacilities", keyword); // 이거 끝나고 구독홈 가는 길이나, 구독하기 버튼 눌렀을 때 faciliites를 초기화 해줘야 해!
      }
      // axios({
      //   method: "GET",
      //   url: `http://localhost:9999/gyudok-subs/facsubs/search/${this.keyword}`,
      // }).then((response) => {
      //   console.log(response.data);
      // });
    },
  },
};
</script>

<style></style>
