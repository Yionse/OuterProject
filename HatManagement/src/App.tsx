import { BrowserRouter, Routes, Route } from "react-router-dom";
import Login from "@/pages/Login";
import Home from "@/pages/Home";
import Data from "./pages/User/Data";
import Views from "./pages/User/Views";
import Index from "./pages/Index";
import { TabListProvider } from "./contexts/Tabs";
import dayjs from "dayjs";
import advancedFormat from "dayjs/plugin/advancedFormat";
import customParseFormat from "dayjs/plugin/customParseFormat";
import localeData from "dayjs/plugin/localeData";
import weekday from "dayjs/plugin/weekday";
import weekOfYear from "dayjs/plugin/weekOfYear";
import weekYear from "dayjs/plugin/weekYear";
import Hat from "./pages/Hat";
import Fence from "./pages/Fence";
import Location from "./pages/Location";
import Warn from "./pages/Warn";

dayjs.extend(customParseFormat);
dayjs.extend(advancedFormat);
dayjs.extend(weekday);
dayjs.extend(localeData);
dayjs.extend(weekOfYear);
dayjs.extend(weekYear);
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
            <Route path="hat" element={<Hat />} />
            <Route path="fence" element={<Fence />} />
            <Route path="location" element={<Location />} />
            <Route path="Warn" element={<Warn />} />
          </Route>
        </Routes>
      </BrowserRouter>
    </TabListProvider>
  );
}
