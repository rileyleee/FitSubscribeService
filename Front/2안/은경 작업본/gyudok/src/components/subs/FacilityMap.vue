<template>
  <v-container>
    <h2>운동시설 위치 보기</h2>
    <v-container id="map"> </v-container>
  </v-container>
</template>

<script>
export default {
  name: "FacilityMap",
  data() {
    return {
      map: null,
    };
  },
  created() {},
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
        "//dapi.kakao.com/v2/maps/sdk.js?appkey=8b159fa998a0332c8053c25757f4a4c8&autoload=false";
      script.onload = () => window.kakao.maps.load(this.loadMap);
      document.head.appendChild(script);
    },

    loadMap() {
      const container = document.getElementById("map"); //지도를 담을 영역의 DOM 레퍼런스
      var options = {
        //지도를 생성할 때 필요한 기본 옵션
        center: new window.kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
        level: 3, //지도의 레벨(확대, 축소 정도)
      };

      this.map = new window.kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
    },
  },
};
</script>

<style>
#map {
  width: 100%;
  height: 400px;
}
</style>