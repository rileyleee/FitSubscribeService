<template>
  <div>
    <div>
      <br />
      <h2>운동시설 상세 조회</h2>
      <table>
        <thead>
          <tr>
            <th><label for="address1">지역구분</label></th>
            <th><label for="factype">시설유형</label></th>
            <th><label for="facname">시설명</label></th>
            <th><label for="fulladdress2">주소</label></th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>
              {{ facility.address1 }}
            </td>
            <td>
              {{ facility.factype }}
            </td>
            <td>
              {{ facility.facname }}
              <button @click="UseFac" id="usebtn">이용하기</button>
            </td>
            <td>
              {{ facility.fulladdress2 }}
            </td>
          </tr>
        </tbody>
      </table>
      <div style="float: right">
        <router-link style="font-size: 0.7em" :to="{ name: 'fac-search' }"
          >검색결과 목록으로</router-link
        >
      </div>
      <div>
        <br />
        <facility-map></facility-map>
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
      if (localStorage.getItem("loginUser") === null) {
        alert("로그인 시 운동시설 예약이 가능합니다. 로그인 화면으로 이동합니다.");
        this.$router.push("/");
      } else {
        let fac_use = {
          user_id: this.$store.state.loginUser.id,
          fac_id: this.$route.query.id,
        };
        this.$store.dispatch("useThisFac", fac_use);
      }
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

<style scoped>
span {
  font-size: 0.5em;
}
#usebtn {
  font-size: 20px;
  width: 80px;
  height: 30px;
  border: none;
  background-color: #2b57a1;
  color: white;
  margin-left: 5px;
  border-radius: 5px;
}
.txtsize0 {
  font-size: 0.1em;
}
.txtsize {
  font-size: 0.2em;
}
input {
  width: 690px;
  height: 50px;
  border-radius: 5px;
}
button {
  width: 100px;
  height: 53px;
  border: none;
  background-color: #2b57a1;
  color: white;
  margin-left: 10px;
  border-radius: 5px;
}
.fulladdtd {
  text-align: left;
}
body {
  padding: 1.5em;
  background: #f5f5f5;
}

table {
  border: 1px #a39485 solid;
  font-size: 0.5em;
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
