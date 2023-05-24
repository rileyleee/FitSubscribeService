<template>
  <div>
    <div class="container">
      <div class="row">
        <div class="col-3">
          <b-card
            title="FIT PASS"
            img-src="https://picsum.photos/300/300/?image=41"
            img-alt="Image"
            img-top
          >
            <b-card-text>
              여행을 떠난 바로 그 곳에서! 업무상 출장을 간 그 곳에서!
            </b-card-text>
            <b-card-text>
              언제 어디서든 건강하고 싶은 당신을 위한 맞춤형 구독상품
            </b-card-text>
            <template #footer>
              <b-card-text
                ><router-link :to="{ name: 'fac-subscribe' }"
                  >운동시설 구독권 신청하기</router-link
                ></b-card-text
              >
            </template>
          </b-card>
        </div>
        <div class="col-9">
          <h2>운동시설 검색하기</h2>
          <!--지역-->
          <!-- (광역시도, 시군구, 운동시설 유형, 운동시설명) -->
          <!--운동종류-->
          <!--체력단련장(필라테스, 피트니스),태권도,인공암벽장,골프(장),합기도, 테니스(장),배드민턴,권투,농구,축구,유도,수영장-->
          <fieldset>
            <input
              type="text"
              id="keyword"
              v-model="keyword"
              placeholder="운동 종류 및 지역명을 입력해주세요"
              @keyup.enter="searchFacs"
            />
            <button variant="primary" @click="searchFacs">검 색</button>
            <br />
            <div></div>
            <br />
            <FacilitySearchResult :keyword="keyword"></FacilitySearchResult>
          </fieldset>
        </div>
      </div>
    </div>
    <div>
      <router-link :to="{ name: 'fac-use' }">이용한 운동시설 목록</router-link>
    </div>
  </div>
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

<style scoped>
input {
  width: 500px;
  height: 50px;
  border-radius: 5px;
}
button {
  width: 100px;
  height: 53px;
  border: none;
  background-color: rgb(97, 145, 222);
  color: white;
  margin-left: 5px;
  border-radius: 5px;
}
</style>
