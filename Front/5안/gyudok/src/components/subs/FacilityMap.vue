<template>
  <div style="padding-top: 10px">
    <h2>운동시설 위치 보기</h2>
    <div id="map"></div>
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "FacilityMap",
  data() {
    return {
      map: null,
      facility: "",
    };
  },
  created() {
    console.log(this.$route.query.id);
    const API_URL = `http://localhost:9999/gyudok-subs/facility/${this.$route.query.id}`;
    axios({
      url: API_URL,
      method: "GET",
    })
      .then((res) => {
        console.log(res.data);
        this.facility = res.data;
      })
      .then(this.loadScript())
      .catch((err) => {
        console.log(err);
      });
  },
  mounted() {
    if (window.kakao && window.kakao.maps) {
      this.loadMap();
    } else {
      this.loadScript();
    }
  },
  methods: {
    loadScript() {
      const script = document.createElement("script");
      script.src =
        "//dapi.kakao.com/v2/maps/sdk.js?appkey=8b159fa998a0332c8053c25757f4a4c8&libraries=services&autoload=false";
      script.onload = () => window.kakao.maps.load(this.loadMap);
      document.head.appendChild(script);
    },

    loadMap() {

      var facAddress = this.facility.fulladdress2;
      var facName = this.facility.facname;

      const container = document.getElementById("map"); //지도를 담을 영역의 DOM 레퍼런스
      var options = {
        //지도를 생성할 때 필요한 기본 옵션 -> 첫 위치는 관계 없음
        center: new window.kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
        level: 3, //지도의 레벨(확대, 축소 정도)
      };

      this.map = new window.kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
      // 주소-좌표 변환 객체를 생성합니다
      const geocoder = new window.kakao.maps.services.Geocoder();

      // 주소로 좌표를 검색합니다
      geocoder.addressSearch(
        //화살표 함수는 자체적인 this를 가지지 않고 주변의 스코프를 유지하기 때문에 this.map을 올바르게 참조할 수 있습니다.
        facAddress,
        (result, status) => {
          // 정상적으로 검색이 완료됐으면
          if (status === window.kakao.maps.services.Status.OK) {
            var coords = new window.kakao.maps.LatLng(result[0].y, result[0].x);
            // 결과값으로 받은 위치를 마커로 표시합니다
            var marker = new window.kakao.maps.Marker({
              map: this.map,
              position: coords,
            });

            // 인포윈도우로 장소에 대한 설명을 표시합니다
            var infowindow = new window.kakao.maps.InfoWindow({
              content: `<div id="infowindow">${facName}</div>`,
            });
            infowindow.open(this.map, marker);

            // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
            this.map.setCenter(coords);
          }
        }
      );
    },
  },
};
</script>

<style scoped>
#infowindow {
  text-align: center;
  width: 200px;
  height: 100px;
  padding: 6px 0;
}
#map {
  width: 100%;
  height: 700px;
  font-size: 0.15em;
  border-radius: 20px;
  border: 2px;
}
</style>