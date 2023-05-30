<template>
    <div>
      <header-nav></header-nav>
      <router-view />
      <FooterPart></FooterPart>
    </div>
</template>

<script>
import FooterPart from "./components/common/FooterPart.vue";
import HeaderNav from "./components/common/HeaderNav.vue";

export default {
  name: "App",
  components: { HeaderNav, FooterPart },

  data: () => ({}),
};
</script>
