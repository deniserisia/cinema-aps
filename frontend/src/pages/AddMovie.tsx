import { useState } from "react";
import { Box, Button, Stack, Typography } from "@mui/material";
import ArrowBackIcon from "@mui/icons-material/ArrowBack";
import DashboardLayout from "../components/Dashboard/DashboardLayout";

import { Link } from "react-router-dom";
import AddMovieForm from "../components/AddMovieForm";

const AddMovie = () => {
  const [formData, setFormData] = useState({
    title: "",
    synopsis: "",
    duration: "",
    classification: "Livre",
    launchYear: "2022",
    genre: "Ação"
  });

  const handleChange = (e: any) => {
    setFormData((prev) => ({
      ...prev,
      [e.target.name]: e.target.value
    }));
  };

  const handleSubmit = (e: any) => {
    e.preventDefault();
    console.log(formData);
  };

  return (
    <DashboardLayout>
      <Box sx={{ display: "flex", justifyContent: "space-between", mb: 3 }}>
        <Stack>
          <Button
            startIcon={<ArrowBackIcon />}
            component={Link}
            to="/filmes"
            variant="text"
            size="small"
            color="secondary"
            sx={{ display: "flex", justifyContent: "start", px: 0 }}>
            Voltar para Filmes
          </Button>
          <Typography variant="h4" sx={{ fontWeight: "bold" }}>
            Adicionar Filme
          </Typography>
        </Stack>
      </Box>
      <Box>
        <AddMovieForm formData={formData} handleChange={handleChange} handleSubmit={handleSubmit} />
      </Box>
    </DashboardLayout>
  );
};

export default AddMovie;
