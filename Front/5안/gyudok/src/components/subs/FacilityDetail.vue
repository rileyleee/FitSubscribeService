<template>
  <div>
    <h1>운동시설 상세 조회</h1>
    <div>
      <facility-map></facility-map>
    </div>
    <div>
      <tr>
        <td><label for="address1">지역구분</label></td>
        <td><label for="factype">시설유형</label></td>
        <td><label for="facname">시설명</label></td>
        <td><label for="rating">평점</label></td>
        <td><label for="fulladdress2">주소</label></td>
      </tr>
      <tr>
        <td>
          <div>{{ facility.address1 }}</div>
        </td>
        <td>
          <div>{{ facility.factype }}</div>
        </td>
        <td>
          <div>{{ facility.facname }}</div>
        </td>
        <td>
          <div>{{ facility.rating }}점</div>
        </td>
        <td>
          <div>{{ facility.fulladdress2 }}</div>
        </td>
      </tr>
      <div>
        <router-link :to="{ name: 'fac-searchresult' }">목록으로</router-link>
      </div>
      <button @click="UseFac">이용하기 버튼</button>
    </div>
  </div>
</template>

<script>
import FacilityMap from "./FacilityMap.vue";
import axios from "axios";
//import { mapGetters } from "vuex";

export default {
  name: "FacilityDetail",
  components: {
    FacilityMap,
  },
  data(){
    return{
      facility:"",
    }
  },
  // computed: {
  //   ...mapGetters(["facility"]),
  // },
  methods: {
    async UseFac() {
      let fac_use = {
        user_id: this.$store.state.loginUser.id,
        fac_id: this.$route.query.id,
      };
      this.$store.dispatch("useThisFac", fac_use);
      //this.$router.push("{ name: 'fac-use' }");
      // 나중에 운동시설 이용내역화면으로 보내주기
      // this.$router.push({
      //   name: "movie-detail",
      //   query: { id: this.$route.query.id },
      //});
    },
  },
  created() {
    //this.$store.dispatch("getFacility", this.$route.query.id);
    const API_URL = `http://localhost:9999/gyudok-subs/facility/${this.$route.query.id}`;
      axios({
        url: API_URL,
        method: "GET",
      })
        .then((res) => {
         //console.log(res.data);
          this.facility = res.data;
        })
        .catch((err) => {
          console.log(err);
        });
  },
  
};
</script>

<style></style>
