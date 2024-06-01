import React, { useContext, useEffect, useState } from "react";
import { Card, Layout, Menu, Tabs, message, theme } from "antd";
import { Outlet, useNavigate } from "react-router-dom";
import { routes } from "@/routes";
import admin from "@/assets/admin.png";
import { TabListContext } from "@/contexts/Tabs";

const { Content, Sider } = Layout;

const Home: React.FC = () => {
  const [collapsed, setCollapsed] = useState(false);
  const [isShowTitle, setIsShowTitle] = useState(true);
  const [title, setTitle] = useState("主页");
  const { tabs, setTabs, activeKey, setActiveKey } = useContext(TabListContext);
  const {
    token: { colorBgContainer },
  } = theme.useToken();
  const navigate = useNavigate();
  document.title = "安全帽管理平台";
  const onChange = (newActiveKey: string) => {
    navigate(newActiveKey);
    setActiveKey(newActiveKey);
  };
  const add = (newKey: string, label: string) => {
    const newPanes = [...tabs];
    newPanes.push({
      label,
      key: newKey,
    });
    setTabs(newPanes);
    setActiveKey(newKey);
  };

  const remove = (targetKey: string) => {
    let newActiveKey = activeKey;
    let lastIndex = -1;
    tabs.forEach((item, i) => {
      if (item.key === targetKey) {
        lastIndex = i - 1;
      }
    });
    const newPanes = tabs.filter((item) => item.key !== targetKey);
    if (newPanes.length && newActiveKey === targetKey) {
      if (lastIndex >= 0) {
        newActiveKey = newPanes[lastIndex].key;
      } else {
        newActiveKey = newPanes[0].key;
      }
    }
    setTabs(newPanes);
    navigate(newActiveKey);
    setActiveKey(newActiveKey);
  };

  const onEdit = (targetKey: string, action: "add" | "remove") => {
    if (action === "remove") {
      if (tabs.length === 1) {
        message.warning("当前仅剩一个标签页了！");
        return;
      }
      remove(targetKey);
    }
  };
  return (
    <>
      <div
        className="h-12 text-lg"
        style={{
          background: "#29a176",
          lineHeight: "48px",
          paddingLeft: "48px",
          color: "white",
        }}
      >
        安全帽管理平台
      </div>
      <Layout
        style={{
          minHeight: "calc(100vh - 48px)",
          boxShadow: "0px -12px 15px -9px rgba(0,0,0,0.2)",
        }}
      >
        <Sider
          collapsible
          collapsed={collapsed}
          onCollapse={(value) => {
            setCollapsed(value);
            setIsShowTitle(!isShowTitle);
          }}
        >
          <div
            className="demo-logo-vertical  box-border justify-center  mx-auto text-center"
            onClick={() => navigate("/home/index")}
            style={{
              background: "#29a176",
            }}
          >
            <img src={admin} className="w-24 h-24 rounded-full" />
            <div
              style={{
                height: "48px",
                lineHeight: "48px",
                background: "rgba(0,0,0,.2)",
              }}
            >
              admin,您好
            </div>
          </div>
          <Menu
            theme="dark"
            mode="inline"
            items={routes}
            onClick={({ keyPath, domEvent }: any) => {
              let path: string = "/home";
              for (let i = keyPath.length; i > 0; i--) {
                if (keyPath[i - 1] === "home") {
                  path += "/index";
                  break;
                }
                path += `/${keyPath[i - 1]}`;
              }
              setTitle(domEvent.target.innerText);
              navigate(path);
              if (!tabs.map((item) => item.key).includes(path)) {
                add(path, domEvent.target.innerText);
              } else {
                setActiveKey(path);
              }
            }}
          />
        </Sider>
        <Layout>
          <div className="h-12 px-4" style={{ background: "#29a176" }}>
            <Tabs
              type="editable-card"
              onChange={onChange}
              activeKey={activeKey}
              onEdit={onEdit as any}
              items={tabs}
            />
          </div>
          <Content style={{ margin: "16px" }}>
            <Card style={{ height: "100%" }}>
              <Outlet />
            </Card>
          </Content>
        </Layout>
      </Layout>
    </>
  );
};

export default Home;
