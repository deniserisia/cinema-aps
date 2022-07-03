import { useEffect } from "react";
import { Box, Divider, Drawer, Typography, useMediaQuery } from "@mui/material";
import NavItem from "../NavItem";
import BarChartIcon from "@mui/icons-material/BarChart";
import GroupIcon from "@mui/icons-material/Group";
import LocalActivityIcon from "@mui/icons-material/LocalActivity";
import InsertInvitationIcon from "@mui/icons-material/InsertInvitation";
import EventSeatIcon from "@mui/icons-material/EventSeat";

interface Props {
  open: boolean;
  onClose: () => void;
}

const items = [
  {
    href: "/dashboard",
    icon: <BarChartIcon />,
    title: "Dashboard"
  },
  {
    href: "/users",
    icon: <GroupIcon />,
    title: "Usuários"
  },
  {
    href: "/events",
    icon: <LocalActivityIcon />,
    title: "Eventos"
  },
  {
    href: "/sessions",
    icon: <InsertInvitationIcon />,
    title: "Sessões"
  },
  {
    href: "/rooms",
    icon: <EventSeatIcon />,
    title: "Salas"
  }
];

const DashboardSidebar = ({ open, onClose }: Props) => {
  const lgUp = useMediaQuery((theme: any) => theme.breakpoints.up("lg"), {
    defaultMatches: true,
    noSsr: false
  });

  useEffect(() => {
    if (open) {
      onClose?.();
    }
  }, []);

  const content = (
    <>
      <Box
        sx={{
          display: "flex",
          flexDirection: "column",
          height: "100%"
        }}>
        <Box sx={{ p: 3 }}>
          <Typography variant="h4">SIGEv</Typography>
        </Box>
        <Divider
          sx={{
            borderColor: "#2D3748",
            my: 3
          }}
        />
        <Box sx={{ flexGrow: 1 }}>
          {items.map((item) => (
            <NavItem key={item.title} icon={item.icon} href={item.href} title={item.title} />
          ))}
        </Box>
      </Box>
    </>
  );

  if (lgUp) {
    return (
      <Drawer
        anchor="left"
        open
        PaperProps={{
          sx: {
            backgroundColor: "neutral.900",
            color: "#FFFFFF",
            width: 280
          }
        }}
        variant="permanent">
        {content}
      </Drawer>
    );
  }

  return (
    <Drawer
      anchor="left"
      onClose={onClose}
      open={open}
      PaperProps={{
        sx: {
          backgroundColor: "neutral.900",
          color: "#FFFFFF",
          width: 280
        }
      }}
      sx={{ zIndex: (theme) => theme.zIndex.appBar + 100 }}
      variant="temporary">
      {content}
    </Drawer>
  );
};

export default DashboardSidebar;