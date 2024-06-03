window.onload = function () {
  const btn = document.querySelector("#btn");
  btn.addEventListener("click", () => {
    alert("你确定要退出登录吗？");
  });
};
