<template>
  <div>
    <div>
      <div class="row">
        <div class="col-3">
          <b-card
            title="FIT PASS"
            img-src="https://i.pinimg.com/474x/0a/39/75/0a3975ed1be8d2d184c86f2ded92aa5f.jpg"
            img-alt="Image"
            img-top
          >
            <b-card-text class="txtsize">
              여행을 떠난 바로 그 곳에서! 업무상 출장을 간 그 곳에서!
            </b-card-text>
            <b-card-text class="txtsize">
              언제든 어디서든 운동하는 당신을 위한 구독 상품
            </b-card-text>
            <template #footer>
              <b-card-text class="txtsize" style="text-align: center"
                ><router-link :to="{ name: 'fac-subscribe' }"
                  >운동시설 구독 <br/>"FIT PASS" 신청</router-link
                ></b-card-text
              >
            </template>
          </b-card>
          <div style="text-align: center; padding-top: 20px">
            <h2>광고 들어갈 자리</h2>
          </div>
        </div>
        <div class="col-9">
          <h2>운동시설 검색하기</h2>
          <!--지역-->
          <!-- (광역시도, 시군구, 운동시설 유형, 운동시설명) -->
          <!--운동종류-->
          <!--체력단련장(필라테스, 피트니스),태권도,인공암벽장,골프(장),합기도, 테니스(장),배드민턴,권투,농구,축구,유도,수영장-->
          <fieldset>
            <input
              class="searchtxtsize"
              type="text"
              id="keyword"
              v-model="keyword"
              placeholder=" 운동 종류 및 지역명을 입력해주세요"
              @keyup.enter="searchFacs"
            />
            <button class="searchtxtsize" variant="primary" @click="searchFacs">
              검 색
            </button>
          </fieldset>
          <div style="padding-top: 15px"></div>
          <FacilitySearchResult :keyword="keyword"></FacilitySearchResult>
        </div>
      </div>
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
.searchtxtsize {
  font-size: 0.4em;
}
.txtsize0 {
  font-size: 0.1em;
}
.txtsize {
  font-size: 0.25em;
}
input {
  width: 715px;
  height: 50px;
  border-radius: 5px;
}
button {
  width: 100px;
  height: 53px;
  border: none;
  background-color: #2b57a1;
  color: white;
  margin-left: 8px;
  border-radius: 5px;
}
</style>
