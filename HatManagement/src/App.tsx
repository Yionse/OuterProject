import { BrowserRouter, Routes, Route } from "react-router-dom";
import Login from "@/pages/Login";
import Home from "@/pages/Home";
import Data from "./pages/User/Data";
import Views from "./pages/User/Views";
import Index from "./pages/Index";
import { TabListProvider } from "./contexts/Tabs";
export default function App() {
  return (
    <TabListProvider>
      <BrowserRouter>
        <Routes>
          <Route index element={<Login />} />
          <Route path="home" element={<Home />}>
            <Route index path="index" element={<Index />} />
            <Route path="user">
              <Route index path="list" element={<Data />} />
              <Route path="add" element={<Views />} />
            </Route>
          </Route>
        </Routes>
      </BrowserRouter>
    </TabListProvider>
  );
}
