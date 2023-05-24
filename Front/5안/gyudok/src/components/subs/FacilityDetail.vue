<template>
  <div>
    <div>
      <span>운동시설 상세 조회</span>
      <button @click="UseFac">이용하기</button>
      <br />
      <div>
        <tr>
          <th><label for="address1">지역구분</label></th>
          <th><label for="factype">시설유형</label></th>
          <th><label for="facname">시설명</label></th>
          <th><label for="fulladdress2">주소</label></th>
        </tr>
        <tr>
          <td>
            {{ facility.address1 }}
          </td>
          <td>
            {{ facility.factype }}
          </td>
          <td>
            {{ facility.facname }}
          </td>
          <td>
            {{ facility.fulladdress2 }}
          </td>
        </tr>
      </div>
      <div>
        <facility-map></facility-map>
      </div>
      <div>
        <router-link :to="{ name: 'fac-searchresult' }">목록으로</router-link>
      </div>
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
  data() {
    return {
      facility: "",
    };
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

<style>
th {
  text-align: center;
}
td {
  text-align: center;
}
</style>
