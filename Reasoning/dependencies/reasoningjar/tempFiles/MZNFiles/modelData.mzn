% Autogenerated code form the Coffee framework
% Author: avillota
% Variables from elements definitions 
var bool : casa ;
var bool : bano ;
var bool : garaje ;
var bool : cuartoPrincipal ;
var bool : AnteMinusJardin ;
var bool : cuartoInvitador ;
var bool : cocina ;
% Variables and constraints from the variability relations definition
constraint casa = true ;
constraint casa <-> ( garaje \/ AnteMinusJardin ) ;
constraint cocina <-> (not(bano) /\ casa) ;
constraint bano <-> (not(cocina) /\ casa) ;
constraint cuartoPrincipal <-> casa ;
constraint cuartoInvitador -> casa ;
constraint cuartoPrincipal -> garaje ;
constraint not (AnteMinusJardin /\ cuartoInvitador);
% The solving parameters from the parameters files
