import React from "react";
import { Stack, TextField } from "@mui/material";
import FormProps from "./formTypes";

const ContactForm = ({ data, handleChange }: FormProps) => {
  return (
    <Stack spacing={2}>
      <TextField
        name="email"
        label="Email"
        fullWidth
        size="small"
        value={data.email}
        onChange={handleChange}
      />
      <TextField
        name="telefone"
        label="Telefone"
        fullWidth
        size="small"
        value={data.telefone}
        onChange={handleChange}
      />
    </Stack>
  );
};

export default ContactForm;