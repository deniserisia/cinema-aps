import {
  Box,
  Typography,
  Button,
  Table,
  TableHead,
  TableRow,
  TableCell,
  TableBody
} from "@mui/material";
import { IUser } from "../types/IUser";
import EditIcon from "@mui/icons-material/Edit";
import DeleteIcon from "@mui/icons-material/Delete";
import UserRow from "./UserRow";

interface Props {
  users?: IUser[];
}

const UsersList = ({ users }: Props) => {
  return (
    <Box sx={{ minWidth: 1000 }}>
      <Table>
        <TableHead>
          <TableRow>
            <TableCell>Nome</TableCell>
            <TableCell>Email</TableCell>
            <TableCell>Documento</TableCell>
            <TableCell>Telefone</TableCell>
            <TableCell>Nascimento</TableCell>
            <TableCell>Função</TableCell>
            <TableCell>Ações</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {users?.slice(0, 10).map((user) => (
            <UserRow user={user} />
          ))}
        </TableBody>
      </Table>
    </Box>
  );
};

export default UsersList;
