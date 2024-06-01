import { routes } from "@/routes";
import { createContext, useEffect, useState } from "react";

export const TabListContext = createContext<{
  tabs: {
    label: string;
    key: string;
  }[];
  setTabs: React.Dispatch<
    React.SetStateAction<
      {
        key: string;
        label: string;
      }[]
    >
  >;
  activeKey: string;
  setActiveKey: React.Dispatch<React.SetStateAction<string>>;
}>({} as any);

export function TabListProvider(props: any) {
  const [activeKey, setActiveKey] = useState("/home/index");
  const [tabs, setTabs] = useState<{ label: string; key: string }[]>([
    {
      label: "主页",
      key: "/home/index",
    },
  ]);
  const routerText = routes.map((item) => {
    if (item?.children) {
      const arr: any[] = item.children.map((items) => {
        return { key: `${item.key}/${items.key}`, label: items.label };
      });
      return [...arr];
    } else {
      return { key: item?.key, label: item.label };
    }
  });

  useEffect(() => {
    if (location.pathname !== "/home/index") {
      const currentRoutes = location.pathname.replace("/home/", "");
      routerText.forEach((item) => {
        if (item instanceof Array) {
          const temp = item?.find((items) => items?.key === currentRoutes);
          setTabs([{ key: `/home/${temp.key}`, label: temp.label }]);
          setActiveKey(`/home/${temp.key}`);
          return;
        } else {
          setTabs([{ key: `/home/${item?.key}`, label: item?.label }]);
          setActiveKey(`/home/${item?.key}`);
        }
      });
    }
  }, []);

  useEffect(() => {
    console.log(tabs, "123");
  }, [tabs]);
  return (
    <TabListContext.Provider value={{ tabs, setTabs, activeKey, setActiveKey }}>
      {props.children}
    </TabListContext.Provider>
  );
}
