--
-- Name: giftentity; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.giftappentity (
    id bigint NOT NULL,
    name character varying(255)
);


ALTER TABLE public.giftappentity OWNER TO postgres;

--
-- Name: giftentity_aud; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.giftappentity_aud (
    id bigint NOT NULL,
    rev integer NOT NULL,
    revtype smallint,
    name character varying(255)
);


ALTER TABLE public.giftappentity_aud OWNER TO postgres;

--
-- Name: giftseq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.giftappseq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.giftappseq OWNER TO postgres;

--
-- Data for Name: giftentity; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.giftappentity (id, name) FROM stdin;
\.


--
-- Data for Name: giftentity_aud; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.giftappentity_aud (id, rev, revtype, name) FROM stdin;
\.


--
-- Name: giftseq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.giftappseq', 1, false);


--
-- Name: giftentity_aud giftentity_aud_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.giftappentity_aud
    ADD CONSTRAINT giftappentity_aud_pkey PRIMARY KEY (id, rev);


--
-- Name: giftentity giftentity_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.giftappentity
    ADD CONSTRAINT giftappentity_pkey PRIMARY KEY (id);


--
-- Name: giftentity_aud fkni7bi0t9iqefvqyt3ilpwxgyk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.giftappentity_aud
    ADD CONSTRAINT fkqf37sw3g5btgihbqc2ykoukx8 FOREIGN KEY (rev) REFERENCES public.revinfo(rev);

